package com.tuling.xml.controller;

import com.tuling.xml.service.LongTimeAsyncCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Callable;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 注意：异步模式对前端来说，是无感知的，这是后端的一种技术。
 * 所以这个和我们自己开启一个线程处理，立马返回给前端是有非常大的不同的，需要注意~
 */
@Controller
public class AsyncController {
    @Autowired
    LongTimeAsyncCallService longTimeAsyncCallService;

    //传统的同步模式的Controller是返回ModelAndView，
    // 而异步模式则是返回DeferredResult<ModelAndView>。
    @RequestMapping(value="/asynctask", method = RequestMethod.GET)
    public DeferredResult<ModelAndView> asyncTask(){
        DeferredResult<ModelAndView> deferredResult = new DeferredResult<ModelAndView>();
        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());
        longTimeAsyncCallService.makeRemoteCallAndUnknownWhenFinish(result -> {
            System.out.println("异步调用执行完成, thread id is : " + Thread.currentThread().getId());
            ModelAndView mav = new ModelAndView("a");
            mav.addObject("source", result);
            deferredResult.setResult(mav);
        });
        return deferredResult;
    }

    @RequestMapping(value="/longtimetask", method = RequestMethod.GET)
    public WebAsyncTask longTimeTask(){
        System.out.println("/longtimetask被调用 thread id is : " + Thread.currentThread().getId());
        Callable<ModelAndView> callable = new Callable<ModelAndView>() {
            public ModelAndView call() throws Exception {
                Thread.sleep(3000); //假设是一些长时间任务
                ModelAndView mav = new ModelAndView("longtimetask");
                mav.addObject("result", "执行成功");
                System.out.println("执行成功 thread id is : " + Thread.currentThread().getId());
                return mav;
            }
        };
        return new WebAsyncTask(callable);
    }
}
