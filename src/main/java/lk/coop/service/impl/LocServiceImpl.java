package lk.coop.service.impl;

import lk.coop.dto.request.LocRequest;
import lk.coop.dto.request.LocUpdateRequest;
import lk.coop.dto.response.LocResponse;
import lk.coop.entity.Loc;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.LocRepository;
import lk.coop.service.LocService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocServiceImpl implements LocService {

    @Autowired
    private LocRepository locRepository;



    @Override
@Transactional
    public LocResponse save(LocRequest request) {

        Loc loc=new Loc();
loc.setLocCode(request.getLocCode());
loc.setLocName(request.getLocName());
loc.setIsDeleted(Deleted.NO);
        loc.setStatus(Status.ACTIVE);

Loc save=locRepository.save(loc);

        return convert(save);
    }

    @Override
    @Transactional
    public LocResponse update(LocUpdateRequest request) {

Loc loc = locRepository.findById(request.getLocid()).orElse(null);
        if(loc==null){
            return null;
        }

loc.setId(request.getLocid());
loc.setLocCode(request.getLocCode());
loc.setLocName(request.getLocName());
//loc.setLocid(request.getLocid());
Loc updated=locRepository.save(loc);

        return (convert(updated));
    }

    @Override
    public LocResponse getById(Integer id) {

       return locRepository.findById(id).map(LocServiceImpl::convert).orElse(null);
    }

    @Override
    public List<LocResponse> getAll() {

        return  locRepository.findAll()
                .stream().map(LocServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Loc got=locRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }
        //got.setIsDeleted(Deleted.YES);
        locRepository.save(got);

        return  1;
    }

private static LocResponse convert(Loc loc){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        LocResponse typeResponse=new LocResponse();
typeResponse.setLocCode(loc.getLocCode());
typeResponse.setLocName(loc.getLocName());
typeResponse.setLocid(loc.getId());
       // typeResponse.setLocid(loc.getLocid());
        typeResponse.setCreatedBy(loc.getCreatedBy());
        typeResponse.setCreatedDateTime(sdf.format(loc.getCreatedDateTime()));
        typeResponse.setModifiedBy(loc.getModifiedBy());
        typeResponse.setModifiedDateTime(sdf.format(loc.getModifiedDateTime()));
        typeResponse.setIsDeleted(loc.getIsDeleted());
    typeResponse.setStatus(loc.getStatus());

return typeResponse;
    }
}