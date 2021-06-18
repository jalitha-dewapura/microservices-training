package lk.codelabs.rentcloud.rentprocesstask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class RentProcessTaskRunner implements CommandLineRunner {

    @Autowired
    RentProcessService rentProcessService;

    @Override
    public void run(String... args) throws Exception {

        if(args.length > 0){
            System.out.println("Task running with arguments");

            if( rentProcessService.validateDL(args[0]) )
                System.out.println("Valid driving license");
            else
                System.out.println("Invalid driving license");
        }
        else
            System.out.println("Task running without arguments");

    }
}
