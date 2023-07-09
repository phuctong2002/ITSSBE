package com.example.ITSSBE;

import com.example.ITSSBE.converter.EquipmentConverter;
import com.example.ITSSBE.dto.EquipmentDTO;
import com.example.ITSSBE.entity.Equipment;
import com.example.ITSSBE.repository.IEquipmentRepo;
import com.example.ITSSBE.service.EquipmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class ItssbeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private IEquipmentRepo equipmentRepo;

	private EquipmentConverter equipmentConverter;
	private EquipmentService equipmentService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		equipmentConverter = new EquipmentConverter();
		equipmentService = new EquipmentService();
	}

	@Test
	public void testGetAllEquipments() {
		// Arrange
		Equipment equipment1 = new Equipment();
		equipment1.setId(1);
		equipment1.setName("Equipment 1");

		Equipment equipment2 = new Equipment();
		equipment2.setId(2);
		equipment2.setName("Equipment 2");

		List<Equipment> mockEquipments = Arrays.asList(equipment1, equipment2);

		when(equipmentRepo.findAll()).thenReturn(mockEquipments);

		// Act
		List<EquipmentDTO> result = equipmentService.getAllEquipments();

		// Assert
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals("Equipment 1", result.get(0).getName());
		Assertions.assertEquals("Equipment 2", result.get(1).getName());

		verify(equipmentRepo, times(1)).findAll();
	}

	@Test
	public void testGetAllEquipmentsWhenEmpty() {
		// Arrange
		when(equipmentRepo.findAll()).thenReturn(Collections.emptyList());

		// Act
		List<EquipmentDTO> result = equipmentService.getAllEquipments();

		// Assert
		Assertions.assertTrue(result.isEmpty());

		verify(equipmentRepo, times(1)).findAll();
	}

	@Test
	public void testGetAllEquipmentsWithConversion() {
		// Arrange
		Equipment equipment1 = new Equipment();
		equipment1.setId(1);
		equipment1.setName("Equipment 1");

		Equipment equipment2 = new Equipment();
		equipment2.setId(2);
		equipment2.setName("Equipment 2");

		List<Equipment> mockEquipments = Arrays.asList(equipment1, equipment2);

		when(equipmentRepo.findAll()).thenReturn(mockEquipments);

		// Act
		List<EquipmentDTO> result = equipmentService.getAllEquipments();

		// Assert
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals("Equipment 1", result.get(0).getName());
		Assertions.assertEquals("Equipment 2", result.get(1).getName());

		verify(equipmentRepo, times(1)).findAll();
		verify(equipmentConverter, times(2)).toDTO(any(Equipment.class));
	}

	@Test
	public void testGetEquipmentByIdWhenFound() {
		// Arrange
		int equipmentId = 1;

		Equipment equipment = new Equipment();
		equipment.setId(equipmentId);
		equipment.setName("Equipment 1");

		EquipmentDTO expectedDto = new EquipmentDTO();
		expectedDto.setId(equipmentId);
		expectedDto.setName("Equipment 1");

		when(equipmentRepo.findById(equipmentId)).thenReturn(equipment);
		when(equipmentConverter.toDTO(equipment)).thenReturn(expectedDto);

		// Act
		EquipmentDTO result = equipmentService.getEquipment(equipmentId);

		// Assert
		Assertions.assertEquals(expectedDto.getId(), result.getId());
		Assertions.assertEquals(expectedDto.getName(), result.getName());

		verify(equipmentRepo, times(1)).findById(equipmentId);
		verify(equipmentConverter, times(1)).toDTO(equipment);
	}

	@Test
	public void testGetEquipmentByIdWhenNotFound() {
		// Arrange
		int equipmentId = 1;

		when(equipmentRepo.findById(equipmentId)).thenReturn(null);

		// Act
		EquipmentDTO result = equipmentService.getEquipment(equipmentId);

		// Assert
		Assertions.assertNull(result);

		verify(equipmentRepo, times(1)).findById(equipmentId);
		verifyNoMoreInteractions(equipmentConverter);
	}

}
