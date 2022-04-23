package canhnguyen.controller;

import canhnguyen.model.Book;
import canhnguyen.model.BookForm;
import canhnguyen.model.Category;
import canhnguyen.service.IBookService;
import canhnguyen.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
//@PropertySource("classpath: upload-file.properties")

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;



    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
private Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/books")
    public ModelAndView listBooks(){
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }
//@RequestParam("search")Optional<String> search
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/create")
    public ModelAndView saveBook( BookForm bookForm) {
        MultipartFile file = bookForm.getAvatar();
        String fileName = file.getOriginalFilename();
        String name = bookForm.getName();
        int price = bookForm.getPrice();
        String author = bookForm.getAuthor();
        Category category = bookForm.getCategory();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Book book = new Book(fileName, name, price, author, category);
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new BookForm());
        modelAndView.addObject("message", "New book created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/book/edit");
            modelAndView.addObject("book", book.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Book updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/book/delete");
            modelAndView.addObject("book", book.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteBook(@ModelAttribute("book") Book book) {
        bookService.remove(book.getId());
        return "redirect:books";
    }
}
