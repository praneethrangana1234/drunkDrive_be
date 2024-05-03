package lk.coop.service.authentication;


import lk.coop.dto.authentication.request.FormSaveRequest;
import lk.coop.dto.authentication.request.FormUpdateRequest;
import lk.coop.dto.authentication.response.FormSaveResponse;
import lk.coop.dto.authentication.response.FormsResponse;

import java.util.List;

public interface FormsService {

    FormSaveResponse save(FormSaveRequest request);

    FormSaveResponse update(FormUpdateRequest request);

    FormsResponse getById(Integer id);

    List<FormsResponse> getAll();

    List<FormsResponse> getAllActive();

    FormsResponse delete(Integer id);
}
