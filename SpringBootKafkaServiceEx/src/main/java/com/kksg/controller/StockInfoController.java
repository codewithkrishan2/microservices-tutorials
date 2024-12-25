package com.kksg.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kksg.contants.AppConstants;
import com.kksg.contants.Status;
import com.kksg.dtos.StockInfoRequestDTO;
import com.kksg.dtos.StockInfoResponseDTO;
import com.kksg.entity.StockInfo;
import com.kksg.service.ProducerService;
import com.kksg.service.StockInfoService;
import com.kksg.service.db.MessageStore;
import com.kksg.service.impl.ProducerServiceImpl;
import com.kksg.service.impl.StockInfoServiceImpl;
import com.kksg.util.ApiResponse;
import com.kksg.util.JsonUtil;

@RestController
@RequestMapping("/api/v1/stock")
public class StockInfoController extends BaseController<StockInfo, StockInfoResponseDTO, StockInfoRequestDTO> {

	private StockInfoService stockInfoService;
	private ModelMapper modelMapper;
	private ProducerService producerService;
	private MessageStore messageStore;
	
	protected StockInfoController(StockInfoServiceImpl stockInfoServiceImpl, ModelMapper modelMapper, ProducerServiceImpl producerServiceImpl, MessageStore messageStore) {
		super(stockInfoServiceImpl);
		this.stockInfoService = stockInfoServiceImpl;
		this.modelMapper = modelMapper;
		this.producerService = producerServiceImpl;
		this.messageStore = messageStore;
	}


	@PostMapping("/send")
	public ResponseEntity<ApiResponse<String>> getMessage(@RequestBody StockInfoRequestDTO request) {
		String message = JsonUtil.convertToString(request);
		producerService.sendMessage(message);
		return ResponseEntity.ok(new ApiResponse<>(Status.SUCCESS, null, "Message sent successfully", message));
     }
//	
//	@GetMapping("/all")
//	public String getAllMessage(@RequestBody StockInfoRequestDTO request) {
//		String message = JsonUtil.convertToString(request);
//		producerService.sendMessage(message);
//		this.messageStore.add(message);
//        return "Hello from StockInfo Controller";
//     }
//	
//	@GetMapping("/all")
//    public ResponseEntity<ApiResponse<List<StockInfoResponseDTO>>> getAllMessage() {
//        return ResponseEntity.ok(new ApiResponse<>(Status.SUCCESS, null, null, stockInfoService.getAll()));
//    }
//	
	@Override
	protected StockInfo mapToEntity(StockInfoRequestDTO dto) {
		return modelMapper.map(dto, StockInfo.class);
	}

	@Override
	protected StockInfoResponseDTO mapToResponse(StockInfo entity) {
		return modelMapper.map(entity, StockInfoResponseDTO.class);
	}

	

}
