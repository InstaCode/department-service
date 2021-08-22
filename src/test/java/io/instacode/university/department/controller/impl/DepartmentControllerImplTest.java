package io.instacode.university.department.controller.impl;

import io.instacode.university.department.DepartmentBuilder;
import io.instacode.university.department.dto.DepartmentDTO;
import io.instacode.university.department.model.Department;
import io.instacode.university.department.mapper.DepartmentMapper;
import io.instacode.university.department.mapper.ReferenceMapper;
import io.instacode.university.department.service.DepartmentService;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class DepartmentControllerImplTest {
  //TODO: create the data Test generator class DepartmentBuilder
  private static final String ENDPOINT_URL = "/department-service";
  @MockBean
  private ReferenceMapper referenceMapper;
  @InjectMocks
  private DepartmentControllerImpl departmentController;
  @MockBean
  private DepartmentService departmentService;
  @MockBean
  private DepartmentMapper departmentMapper;
  @Autowired
  private MockMvc mockMvc;

  @Before("")
  public void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.departmentController).build();
  }

  @Test
  public void getAll() throws Exception {
    Mockito.when(departmentMapper.asDTOList(ArgumentMatchers.any())).thenReturn(DepartmentBuilder.getListDTO());

    Mockito.when(departmentService.findAll()).thenReturn(DepartmentBuilder.getListEntities());
    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

  }

  @Test
  public void getById() throws Exception {
    Mockito.when(departmentMapper.asDTO(ArgumentMatchers.any())).thenReturn((DepartmentDTO) DepartmentBuilder.getDTO());

    Mockito.when(departmentService.findById(ArgumentMatchers.anyLong()))
        .thenReturn(java.util.Optional.of(DepartmentBuilder.getEntity()));

    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1")).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
    Mockito.verify(departmentService, Mockito.times(1)).findById(1L);
    Mockito.verifyNoMoreInteractions(departmentService);
  }

  @Test
  public void save() throws Exception {
    Mockito.when(departmentMapper.asEntity(ArgumentMatchers.any())).thenReturn(DepartmentBuilder.getEntity());
    Mockito.when(departmentService.save(ArgumentMatchers.any(Department.class)))
        .thenReturn(DepartmentBuilder.getEntity());

    mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT_URL).contentType(MediaType.APPLICATION_JSON)
        .content(CustomUtils.asJsonString(DepartmentBuilder.getDTO())))
        .andExpect(MockMvcResultMatchers.status().isCreated());
    Mockito.verify(departmentService, Mockito.times(1)).save(ArgumentMatchers.any(Department.class));
    Mockito.verifyNoMoreInteractions(departmentService);
  }

  @Test
  public void update() throws Exception {
    Mockito.when(departmentMapper.asEntity(ArgumentMatchers.any())).thenReturn(DepartmentBuilder.getEntity());
    Mockito.when(departmentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong()))
        .thenReturn(DepartmentBuilder.getEntity());

    mockMvc.perform(MockMvcRequestBuilders.put(ENDPOINT_URL + "/1").contentType(MediaType.APPLICATION_JSON)
        .content(CustomUtils.asJsonString(DepartmentBuilder.getDTO())))
        .andExpect(MockMvcResultMatchers.status().isOk());
    Mockito.verify(departmentService, Mockito.times(1))
        .update(ArgumentMatchers.any(Department.class), ArgumentMatchers.anyLong());
    Mockito.verifyNoMoreInteractions(departmentService);
  }

  @Test
  public void delete() throws Exception {
    Mockito.doNothing().when(departmentService).deleteById(ArgumentMatchers.anyLong());
    mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    Mockito.verify(departmentService, Mockito.times(1)).deleteById(Mockito.anyLong());
    Mockito.verifyNoMoreInteractions(departmentService);
  }
}