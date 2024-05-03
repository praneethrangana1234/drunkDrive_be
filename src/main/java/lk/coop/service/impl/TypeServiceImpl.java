package lk.coop.service.impl;

import lk.coop.dto.request.TypeRequest;
import lk.coop.dto.request.TypeUpdateRequest;
import lk.coop.dto.response.TypeResponse;
import lk.coop.entity.Type;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.TypeRepository;
import lk.coop.service.TypeService;
//import lk.utils.ConvertUtils;
//import lk.enums.Deleted;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;



    @Override
@Transactional
    public TypeResponse save(TypeRequest request) {

        Type type=new Type();
type.setCode(request.getCode());
type.setType(request.getType());
type.setIsDeleted(Deleted.NO);
type.setStatus(Status.ACTIVE);
Type save=typeRepository.save(type);

        return convert(save);
    }

    @Override
    @Transactional
    public TypeResponse update(TypeUpdateRequest request) {

Type type = typeRepository.findById(request.getId()).orElse(null);
        if(type==null){
            return null;
        }

type.setId(request.getId());
type.setCode(request.getCode());
type.setId(request.getId());
type.setType(request.getType());

type.setStatus(request.getStatus());
Type updated=typeRepository.save(type);

        return (convert(updated));
    }

    @Override
    public TypeResponse getById(Integer id) {

       return typeRepository.findById(id).map(TypeServiceImpl::convert).orElse(null);
    }

    @Override
    public List<TypeResponse> getAll() {

        return  typeRepository.findByIsDeleted(Deleted.NO)
                .stream().map(TypeServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Type got=typeRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }
        got.setIsDeleted(Deleted.YES);
        typeRepository.save(got);

        return  1;
    }

private static TypeResponse convert(Type type){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        TypeResponse typeResponse=new TypeResponse();
typeResponse.setCode(type.getCode());
typeResponse.setId(type.getId());
typeResponse.setType(type.getType());
        typeResponse.setId(type.getId());
        typeResponse.setCreatedBy(type.getCreatedBy());
        typeResponse.setCreatedDateTime(sdf.format(type.getCreatedDateTime()));
        typeResponse.setModifiedBy(type.getModifiedBy());
        typeResponse.setModifiedDateTime(sdf.format(type.getModifiedDateTime()));
        typeResponse.setIsDeleted(type.getIsDeleted());
    typeResponse.setStatus(type.getStatus());
return typeResponse;
    }
}