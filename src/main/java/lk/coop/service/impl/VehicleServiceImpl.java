package lk.coop.service.impl;

import lk.coop.dto.request.VehicleRequest;
import lk.coop.dto.request.VehicleUpdateRequest;
import lk.coop.dto.response.VehicleResponse;
import lk.coop.entity.Vehicle;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.VehicleRepository;
import lk.coop.service.VehicleService;
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
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;



    @Override
@Transactional
    public VehicleResponse save(VehicleRequest request) {

        Vehicle vehicle=new Vehicle();
vehicle.setOwner(request.getOwner());
vehicle.setRootId(request.getRootId());
vehicle.setSeatCount(request.getSeatCount());
vehicle.setType(request.getType());
vehicle.setVehicleNo(request.getVehicleNo());
vehicle.setYear(request.getYear());
vehicle.setIsDeleted(Deleted.NO);
vehicle.setStatus(Status.ACTIVE);
Vehicle save=vehicleRepository.save(vehicle);

        return convert(save);
    }

    @Override
    @Transactional
    public VehicleResponse update(VehicleUpdateRequest request) {

Vehicle vehicle = vehicleRepository.findById(request.getId()).orElse(null);
        if(vehicle==null){
            return null;
        }

vehicle.setId(request.getId());
vehicle.setId(request.getId());
vehicle.setOwner(request.getOwner());
vehicle.setRootId(request.getRootId());
vehicle.setSeatCount(request.getSeatCount());
vehicle.setType(request.getType());
vehicle.setVehicleNo(request.getVehicleNo());
vehicle.setYear(request.getYear());
vehicle.setStatus(request.getStatus());
Vehicle updated=vehicleRepository.save(vehicle);

        return (convert(updated));
    }

    @Override
    public VehicleResponse getById(Integer id) {

       return vehicleRepository.findById(id).map(VehicleServiceImpl::convert).orElse(null);
    }

    @Override
    public List<VehicleResponse> getAll() {

        return  vehicleRepository.findByIsDeleted(Deleted.NO)
                .stream().map(VehicleServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Vehicle got=vehicleRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }
        got.setIsDeleted(Deleted.YES);
        vehicleRepository.save(got);

        return  1;
    }

private static VehicleResponse convert(Vehicle vehicle){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        VehicleResponse typeResponse=new VehicleResponse();
typeResponse.setId(vehicle.getId());
typeResponse.setOwner(vehicle.getOwner());
typeResponse.setRootId(vehicle.getRootId());
typeResponse.setSeatCount(vehicle.getSeatCount());
typeResponse.setType(vehicle.getType());
typeResponse.setVehicleNo(vehicle.getVehicleNo());
typeResponse.setYear(vehicle.getYear());
        typeResponse.setId(vehicle.getId());
        typeResponse.setCreatedBy(vehicle.getCreatedBy());
        typeResponse.setCreatedDateTime(sdf.format(vehicle.getCreatedDateTime()));
        typeResponse.setModifiedBy(vehicle.getModifiedBy());
        typeResponse.setModifiedDateTime(sdf.format(vehicle.getModifiedDateTime()));
        typeResponse.setIsDeleted(vehicle.getIsDeleted());
    typeResponse.setStatus(vehicle.getStatus());
return typeResponse;
    }
}