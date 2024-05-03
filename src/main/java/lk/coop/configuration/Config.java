package lk.coop.configuration;


import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Config {

   // @Autowired
  //  CoverNoteReasonService coverNoteReasonService;

  //  @Autowired
  //  PolicyInactiveReasonService policyInactiveReasonService;


    @Scheduled(cron = "0 0 12 * * ?")
    public void expireCoverNotes(){
      //  Integer count = coverNoteReasonService.expireCoverNoteReason();
      //  Integer countInactive=policyInactiveReasonService.expirePolicyInactiveReason();
      //  System.out.println(count);
      //  System.out.println(countInactive);
    }

}