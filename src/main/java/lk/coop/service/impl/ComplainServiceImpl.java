package lk.coop.service.impl;

import lk.coop.dto.request.ComplainRequest;
import lk.coop.dto.request.ComplainUpdateRequest;
import lk.coop.dto.response.ComplainResponse;
import lk.coop.entity.Complain;
import lk.coop.enums.Deleted;
import lk.coop.repository.ComplainRepository;
import lk.coop.service.ComplainService;
//import lk.utils.ConvertUtils;
//import lk.enums.Deleted;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainRepository complainRepository;



    @Override
@Transactional
    public ComplainResponse save(ComplainRequest request) {

        Complain complain=new Complain();
complain.setDate(request.getDate());
complain.setDriverId(request.getDriverId());
complain.setName(request.getName());
complain.setStatus(request.getStatus());
complain.setIsDeleted(Deleted.NO);
Complain save=complainRepository.save(complain);

        return convert(save);
    }

    @Override
    @Transactional
    public ComplainResponse update(ComplainUpdateRequest request) {

Complain complain = complainRepository.findById(request.getId()).orElse(null);
        if(complain==null){
            return null;
        }

complain.setId(request.getId());
complain.setDate(request.getDate());
complain.setDriverId(request.getDriverId());
complain.setId(request.getId());
complain.setName(request.getName());
complain.setStatus(request.getStatus());
Complain updated=complainRepository.save(complain);

        return (convert(updated));
    }

    @Override
    public ComplainResponse getById(Integer id) {

       return complainRepository.findById(id).map(ComplainServiceImpl::convert).orElse(null);
    }

    @Override
    public List<ComplainResponse> getAll() {

        return  complainRepository.findByIsDeleted(Deleted.NO)
                .stream().map(ComplainServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Complain got=complainRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }
        got.setIsDeleted(Deleted.YES);
        complainRepository.save(got);

        return  1;
    }

private static ComplainResponse convert(Complain complain){

        ComplainResponse typeResponse=new ComplainResponse();
typeResponse.setDate(complain.getDate());
typeResponse.setDriverId(complain.getDriverId());
typeResponse.setId(complain.getId());
typeResponse.setName(complain.getName());
typeResponse.setStatus(complain.getStatus());
        typeResponse.setId(complain.getId());
        typeResponse.setCreatedBy(complain.getCreatedBy());
      //  typeResponse.setCreatedDateTime(ConvertUtils.convertDateToStr(complain.getCreatedDateTime()));
        typeResponse.setModifiedBy(complain.getModifiedBy());
      //  typeResponse.setModifiedDateTime(ConvertUtils.convertDateToStr(complain.getModifiedDateTime()));
        typeResponse.setIsDeleted(complain.getIsDeleted());

return typeResponse;
    }
}