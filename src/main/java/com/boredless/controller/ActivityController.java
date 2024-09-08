package com.boredless.controller;

import com.boredless.data.Activity;
import com.boredless.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping("/test")
    public String getActivity() {
        return "hello world!";
    }

    @GetMapping
    public List<Activity> getAllActivities() {
        Activity activity = new Activity("test", "test");
        return List.of(activity);
//        return activityRepository.findAll();
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        activity.setCreatedAt(LocalDateTime.now());
        return activityRepository.save(activity);
    }
}
