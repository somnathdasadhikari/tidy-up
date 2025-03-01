package com.kodekonveyor.work_request.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodekonveyor.work_request.WorkRequestDTO;
import com.kodekonveyor.work_request.WorkRequestEntity;
import com.kodekonveyor.work_request.WorkRequestRepository;

@Controller
public class OpenWorkRequestController {

	@Autowired
	private WorkRequestRepository workRequestRepository;

	@GetMapping("workRequest/own/@workRequestId")
	public WorkRequestDTO call(@RequestParam final long workRequestId) {
		final WorkRequestEntity workRequestEntity = workRequestRepository.findByWorkRequestId(workRequestId).get(0);
		final WorkRequestDTO workRequestDTO = new WorkRequestDTO();
		workRequestDTO.setWorkRequestId(workRequestEntity.getId());
		workRequestDTO.setWorkType(workRequestEntity.getWorkType());

		return workRequestDTO;
	}

}
