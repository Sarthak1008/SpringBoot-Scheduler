package com.example.Spring.Boot.scheduler.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.Spring.Boot.scheduler.entities.User;
import com.example.Spring.Boot.scheduler.repository.UserRepo;

@Service
public class userService {

    @Autowired
    private UserRepo dao;

    Logger log = LoggerFactory.getLogger(userService.class);

    /*
     * Annotation that marks a method to be scheduled. For periodic tasks, exactly
     * one of the cron, fixedDelay, or fixedRate attributes must be specified, and
     * additionally an optional initialDelay. For a one-time task, it is sufficient
     * to just specify an initialDelay.
     * 
     * The annotated method must not accept arguments. It will typically have a void
     * return type; if not, the returned value will be ignored when called through
     * the scheduler.
     */
    // schedule a job to add object in DB (Every 5 sec)
    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        User user = new User();
        user.setName("user" + new Random().nextInt(374483));
        dao.save(user);
        System.out.println("add service call in " + new Date().toString());
    }

    /*
     * Step 2.) Create a Scheduled Task: Define a method in one of your Spring beans
     * (usually a @Component or @Service annotated class) and annotate it
     * with @Scheduled. This annotation allows you to specify the schedule for
     * executing the method.
     */

    /*
     * Step 3.) pecify the Schedule: Inside the @Scheduled annotation, provide a
     * cron
     * expression or specify fixed-rate, fixed-delay, or initial delay for running
     * the method.
     */

    /*
     * Step 4.) A cron-like expression, extending the usual UN*X definition to
     * include triggers on the second, minute, hour, day of month, month, and day of
     * week.
     * 
     * For example, "0 * * * * MON-FRI" means once per minute on weekdays (at the
     * top of the minute - the 0th second).
     */

    /*
     * Cron Expression
     * A cron expression is a string representing a schedule, composed of six or
     * seven fields separated by spaces. Each field represents a unit of time (such
     * as minutes, hours, days, etc.) and determines when a task should be executed.
     * 
     * In the cron expression 0 0 12 1 * ?:
     * 
     * Field 1 (Seconds): 0
     * 
     * Specifies that the task should run at the 0th second of the specified minute.
     * Field 2 (Minutes): 0
     * 
     * Specifies that the task should run at the 0th minute of the specified hour.
     * Field 3 (Hours): 12
     * 
     * Specifies that the task should run at the 12th hour (12 PM).
     * Field 4 (Day of Month): 1
     * 
     * Specifies that the task should run on the 1st day of the month.
     * Field 5 (Month): *
     * 
     * Specifies that the task should run every month.
     * Field 6 (Day of Week): ?
     * 
     * Specifies that the day of the week is not relevant (since we're already
     * specifying the day of the month).
     * Field 7 (Year): (Optional)
     * 
     * Specifies the year. In this case, it is not specified (?), meaning the task
     * will run regardless of the year.
     * So, the cron expression 0 0 12 1 * ? specifies that the task should run at 12
     * PM (noon) on the 1st day of every month, regardless of the day of the week or
     * year.
     */
    @Scheduled(cron = "0 0 12 1 *")
    public void fetchDBJob() {
        List<User> users = dao.findAll();
        System.out.println("fetch service call in " + new Date().toString());
        System.out.println("no of record fetched : " + users.size());
        log.info("users : {}", users);
    }

}
