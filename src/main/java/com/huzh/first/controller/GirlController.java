package com.huzh.first.controller;

import com.huzh.first.domain.Boy;
import com.huzh.first.domain.Result;
import com.huzh.first.repository.BoyRepository;
import com.huzh.first.properties.GirlProperties;
import com.huzh.first.service.BoyService;
import com.huzh.first.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlProperties girlProperties;

    @Autowired
    private BoyRepository boyRepository;

    @Autowired
    private BoyService boyService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(@RequestParam(value="id",required=false,defaultValue="0") int myid){
        return "id"+myid;
    }

    @GetMapping(value="girls")
    public List<Boy> query(){
        return boyRepository.findAll();
    }

    /**
     * 添加一个男孩
     * @return
     */
    @PostMapping(value = "girl")
    public Result<Boy> addBoy(@Valid Boy boy, BindingResult bindingResult){
        Result result = new Result();
        if(bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage(),200);
        }

        return ResultUtil.success(boyRepository.save(boy));
    }
    @GetMapping(value = "girls/{id}")
    public Optional<Boy> girlfindOne(@PathVariable("id") int id){
        return boyRepository.findById(id);
    }
    @PutMapping(value="girls/{id}")
    public Boy updateBoy(@PathVariable(value = "id") int id,
                         @RequestParam(value="name") String name){
        Boy boy = new Boy();
        boy.setId(id);
        boy.setName(name);
       return  boyRepository.save(boy);
    }
    @DeleteMapping(value = "girls/{id}")
    public void deleteBoy(@PathVariable(value = "id") int id){
        Boy boy = new Boy();
        boy.setId(id);
        boyRepository.delete(boy);
    }
    /**
     *通过年龄来查询，按规则自定义方法
     */
    @GetMapping(value = "/boy/{age}")
    public List<Boy> findByAge(@PathVariable(value = "age") String name){
        return boyRepository.findByName(name);
    }
    @GetMapping(value = "/boy/name/{name}")
    public void getName(@PathVariable(value = "name") String name) throws Exception {
        boyService.getName(name);
    }
}
