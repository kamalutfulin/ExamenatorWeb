package com.example.spring.controller;

import com.example.spring.dao.ResultEntity;
import com.example.spring.utils.TakerFile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ExamController {


    static int count1 = 0;
    static int count2 = 0;
    int balance = 0;
    static int number = 2;
    TakerFile takerFile = new TakerFile();

    public ExamController() throws FileNotFoundException {
    }
//    @GetMapping("/examen")
//    public String goToExam(@RequestParam(value = "balance", required = false) Integer balance, String name, Model model) throws IOException, InterruptedException {
//        ArrayList newAr = takerFile.toMakeRandom();
//        if (count1 <= newAr.size() && count1 >= 0) {
//
//            name = (String) newAr.get(count1);
//            model.addAttribute("name", name);
//            count1++;
//            return "exam";
//        }
//
//        return "error";
//    }

    @GetMapping("/balance")
    public String goToExam(int point, String name, Model model) throws IOException, InterruptedException {
        ArrayList newAr = takerFile.toMakeRandom();
        if (count2 < newAr.size() && count2 >= 0) {
            balance += point;
            name = (String) newAr.get(count2);
            model.addAttribute("number", number);
            model.addAttribute("balance", balance);
            model.addAttribute("name", name);
            number++;
            count2++;
            return "exam";
        } else if (count2 == 45) {
            if (balance > 40) {
                toSaveBase();
                return "super_result";
            } else if (balance > 20 && balance < 40) {
                toSaveBase();
                return "notbad_result";
            } else if (balance <= 20) {
                toSaveBase();
                return "bad_result";
            }
        }

        return "error";
    }


    public void toSaveBase() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(new ResultEntity(balance, new Date()));
            session.getTransaction().commit();
        }
    }
}



