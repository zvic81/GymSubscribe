package com.example.gymsubscribe.service;

import com.example.gymsubscribe.model.Subscribe;

import java.util.List;

public interface SubscribeService {
    List<Subscribe> findAllSubscribe();

    Subscribe saveSubscribe(Subscribe subscribe);

    Subscribe updateSubscribe(Subscribe subscribe);
}
