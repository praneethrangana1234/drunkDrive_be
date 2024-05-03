package lk.coop.service.impl;

import lk.coop.dto.request.RootRequest;
import lk.coop.dto.request.RootUpdateRequest;
import lk.coop.dto.response.RootResponse;
import lk.coop.entity.Root;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.RootRepository;
import lk.coop.service.RootService;
//import lk.utils.ConvertUtils;
//import lk.enums.Deleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    private RootRepository rootRepository;



    @Override
@Transactional
    public RootResponse save(RootRequest request) {

        Root root=new Root();
root.setRootDiscription(request.getRootDiscription());
root.setRootName(request.getRootName());
root.setIsDeleted(Deleted.NO);
root.setStatus(Status.ACTIVE);
Root save=rootRepository.save(root);

        return convert(save);
    }

    @Override
    @Transactional
    public RootResponse update(RootUpdateRequest request) {

Root root = rootRepository.findById(request.getId()).orElse(null);
        if(root==null){
            return null;
        }

root.setId(request.getId());
root.setId(request.getId());
root.setRootDiscription(request.getRootDiscription());
root.setRootName(request.getRootName());
        root.setStatus(request.getStatus());

Root updated=rootRepository.save(root);

        return (convert(updated));
    }

    @Override
    public RootResponse getById(Integer id) {

       return rootRepository.findById(id).map(RootServiceImpl::convert).orElse(null);
    }

    @Override
    public List<RootResponse> getAll() {

        return  rootRepository.findByIsDeleted(Deleted.NO)
                .stream().map(RootServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Root got=rootRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }
        got.setIsDeleted(Deleted.YES);
        rootRepository.save(got);

        return  1;
    }

private static RootResponse convert(Root root){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        RootResponse typeResponse=new RootResponse();
typeResponse.setId(root.getId());
typeResponse.setRootDiscription(root.getRootDiscription());
typeResponse.setRootName(root.getRootName());
        typeResponse.setId(root.getId());
        typeResponse.setCreatedBy(root.getCreatedBy());
        typeResponse.setCreatedDateTime(sdf.format(root.getCreatedDateTime()));
        typeResponse.setModifiedBy(root.getModifiedBy());
        typeResponse.setModifiedDateTime(sdf.format(root.getModifiedDateTime()));
        typeResponse.setIsDeleted(root.getIsDeleted());
    typeResponse.setStatus(root.getStatus());
return typeResponse;
    }
}