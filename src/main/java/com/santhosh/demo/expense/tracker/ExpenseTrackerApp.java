package com.santhosh.demo.expense.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ExpenseTrackerApp
{
    public static void main(String[] args )
    {
        ApplicationContext ctx = SpringApplication.run(ExpenseTrackerApp.class, args);
        System.out.println(ctx.getApplicationName());
        for(String bean : ctx.getBeanDefinitionNames()) {
            System.out.println("Bean Defined "+bean);
        }
    }
}
