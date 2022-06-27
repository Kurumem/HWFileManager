package sberHW.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sberHW.manager.FileManager;

import java.io.File;
import java.io.IOException;

@Controller
public class ExplorerController {

    FileManager fileManager = new FileManager();

    @GetMapping("/")
    public String showExplorer(Model model) {
        model.addAttribute("explorer", fileManager);
        return "index";
    }

    @PostMapping("/")
    public String postExplorer(@RequestParam(value = "param") String path) throws IOException {
        if (path.equals("root")) {
            fileManager = new FileManager(File.listRoots());
        } else {
            fileManager = new FileManager(path);
        }
        return "redirect:/";
    }
}
