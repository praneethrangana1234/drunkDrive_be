package lk.coop.service.impl;

import lk.coop.dto.request.DriverRequest;
import lk.coop.dto.request.DriverUpdateRequest;
import lk.coop.dto.response.DriverResponse;
import lk.coop.entity.Driver;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.DriverRepository;
import lk.coop.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;



    @Override
@Transactional
    public DriverResponse save(DriverRequest request) {

        Driver driver=new Driver();
driver.setAge(request.getAge());
driver.setDob(request.getDob());
driver.setDriverAdd(request.getDriverAdd());
driver.setDriverName(request.getDriverName());
driver.setGender(request.getGender());
driver.setLizenno(request.getLizenno());
driver.setMarrages(request.getMarrages());
driver.setNic(request.getNic());
driver.setRootId(request.getRootId());
driver.setTelNo(request.getTelNo());
driver.setType(request.getType());
driver.setVehicleId(request.getVehicleId());
driver.setIsDeleted(Deleted.NO);
driver.setStatus(Status.ACTIVE);
Driver save=driverRepository.save(driver);

        return convert(save);
    }

    @Override
    @Transactional
    public DriverResponse update(DriverUpdateRequest request) {

Driver driver = driverRepository.findById(request.getId()).orElse(null);
        if(driver==null){
            return null;
        }

driver.setId(request.getId());
driver.setAge(request.getAge());
driver.setDob(request.getDob());
driver.setDriverAdd(request.getDriverAdd());
driver.setDriverName(request.getDriverName());
driver.setGender(request.getGender());
driver.setId(request.getId());
driver.setLizenno(request.getLizenno());
driver.setMarrages(request.getMarrages());
driver.setNic(request.getNic());
driver.setRootId(request.getRootId());
driver.setTelNo(request.getTelNo());
driver.setType(request.getType());
driver.setVehicleId(request.getVehicleId());
driver.setStatus(request.getStatus());

Driver updated=driverRepository.save(driver);

        return (convert(updated));
    }

    @Override
    public DriverResponse getById(Integer id) {

       return driverRepository.findById(id).map(DriverServiceImpl::convert).orElse(null);
    }

    @Override
    public List<DriverResponse> getAll() {

        return  driverRepository.findByIsDeleted(Deleted.NO)
                .stream().map(DriverServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Driver got=driverRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }
        got.setIsDeleted(Deleted.YES);
        driverRepository.save(got);

        return  1;
    }

private static DriverResponse convert(Driver driver){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        DriverResponse typeResponse=new DriverResponse();
typeResponse.setAge(driver.getAge());
typeResponse.setDob(driver.getDob());
typeResponse.setDriverAdd(driver.getDriverAdd());
typeResponse.setDriverName(driver.getDriverName());
typeResponse.setGender(driver.getGender());
typeResponse.setId(driver.getId());
typeResponse.setLizenno(driver.getLizenno());
typeResponse.setMarrages(driver.getMarrages());
typeResponse.setNic(driver.getNic());
typeResponse.setRootId(driver.getRootId());
typeResponse.setTelNo(driver.getTelNo());
typeResponse.setType(driver.getType());
typeResponse.setVehicleId(driver.getVehicleId());
        typeResponse.setId(driver.getId());
        typeResponse.setCreatedBy(driver.getCreatedBy());
        typeResponse.setCreatedDateTime(sdf.format(driver.getCreatedDateTime()));
        typeResponse.setModifiedBy(driver.getModifiedBy());
        typeResponse.setModifiedDateTime(sdf.format(driver.getModifiedDateTime()));
        typeResponse.setIsDeleted(driver.getIsDeleted());
        typeResponse.setStatus(driver.getStatus());

return typeResponse;
    }
}