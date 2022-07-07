package com.example.tffsjavarestapi.controllers;

import com.example.tffsjavarestapi.exceptions.CrudException;
import com.example.tffsjavarestapi.models.dtos.Mappers;
import com.example.tffsjavarestapi.models.dtos.PageDTO;
import com.example.tffsjavarestapi.models.dtos.borrow.BorrowCreateForm;
import com.example.tffsjavarestapi.models.dtos.borrow.BorrowCreateReponse;
import com.example.tffsjavarestapi.services.borrow.BorrowService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/borrow")
@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class BorrowController extends BaseRestController {
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping(path = {"", "/"})
    @Secured(value = {"ROLE_ADMIN", "ROLE_BIBLO"})
    public PageDTO getAllAction(
            @RequestParam(required = false, defaultValue = "0", name = "page") int page,
            @RequestParam(required = false, defaultValue = "15", name = "size") int size) {
        return PageDTO.fromPage(this.borrowService.findAll(page, size));
    }

    @PostMapping(path = {"", "/"})
    public BorrowCreateReponse createAction(@RequestBody() @Valid BorrowCreateForm createForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            StringBuilder builder = new StringBuilder();
//            builder.append("[");
//            for (ObjectError error: bindingResult.getAllErrors()) {
//                builder.append(error.getDefaultMessage()).append(", ");
//            }
//            builder.append("]");
//
//            throw new CrudException(BorrowController.class.toString(), builder.toString());
            throw new CrudException(BorrowController.class.toString(), "Form not valid", bindingResult.getAllErrors());
        }
        return Mappers.fromEntity(this.borrowService.create(createForm.getCustomerId(), createForm.getBookIds()));
    }
}
