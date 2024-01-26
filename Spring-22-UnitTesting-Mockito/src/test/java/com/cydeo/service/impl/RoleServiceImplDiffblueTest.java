package com.cydeo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RoleServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RoleServiceImplDiffblueTest {
    @MockBean
    private MapperUtil mapperUtil;

    @MockBean
    private RoleMapper roleMapper;

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles() {
        when(roleRepository.findAll()).thenReturn(new ArrayList<>());
        List<RoleDTO> actualListAllRolesResult = roleServiceImpl.listAllRoles();
        verify(roleRepository).findAll();
        assertTrue(actualListAllRolesResult.isEmpty());
    }

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles2() {
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(1L);
        role.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setInsertUserId(1L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setLastUpdateUserId(1L);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        when(roleRepository.findAll()).thenReturn(roleList);
        when(mapperUtil.convert(Mockito.<Object>any(), Mockito.<RoleDTO>any())).thenReturn(new RoleDTO());
        List<RoleDTO> actualListAllRolesResult = roleServiceImpl.listAllRoles();
        verify(mapperUtil).convert(Mockito.<Object>any(), Mockito.<RoleDTO>any());
        verify(roleRepository).findAll();
        assertEquals(1, actualListAllRolesResult.size());
    }

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles3() {
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(1L);
        role.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setInsertUserId(1L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role.setLastUpdateUserId(1L);

        Role role2 = new Role();
        role2.setDescription("Description");
        role2.setId(2L);
        role2.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role2.setInsertUserId(2L);
        role2.setIsDeleted(false);
        role2.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        role2.setLastUpdateUserId(2L);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role2);
        roleList.add(role);
        when(roleRepository.findAll()).thenReturn(roleList);
        when(mapperUtil.convert(Mockito.<Object>any(), Mockito.<RoleDTO>any())).thenReturn(new RoleDTO());
        List<RoleDTO> actualListAllRolesResult = roleServiceImpl.listAllRoles();
        verify(mapperUtil, atLeast(1)).convert(Mockito.<Object>any(), Mockito.<RoleDTO>any());
        verify(roleRepository).findAll();
        assertEquals(2, actualListAllRolesResult.size());
    }
}
