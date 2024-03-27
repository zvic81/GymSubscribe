package com.example.gymsubscribe.service.impl;
import java.util.List;
import com.example.gymsubscribe.model.Subscribe;
import com.example.gymsubscribe.repository.SubscribeRepo;
import com.example.gymsubscribe.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscribeServiceImpl implements SubscribeService {
    private final SubscribeRepo subscribeRepo;

    @Override
    public List<Subscribe> findAllSubscribe(){
        return subscribeRepo.findAll();
    }
    @Override
    public Subscribe saveSubscribe(Subscribe subscribe){
        //TODO
        return subscribeRepo.save(subscribe);
      }
    @Override
    public Subscribe updateSubscribe(Subscribe subscribe){
        return subscribeRepo.save(subscribe);
    }
}
