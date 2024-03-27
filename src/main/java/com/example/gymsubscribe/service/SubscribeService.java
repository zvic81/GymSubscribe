package com.example.gymsubscribe.service;
import java.util.List;
import com.example.gymsubscribe.model.Subscribe;

public interface SubscribeService {
    List<Subscribe> findAllSubscribe();
    Subscribe saveSubscribe(Subscribe subscribe);
    Subscribe updateSubscribe(Subscribe subscribe);
}
