package com.moby.dashboard.service.imp;

import com.moby.dashboard.exception.EmptyException;
import com.moby.dashboard.exception.NotFoundTypeIdException;
import com.moby.dashboard.persistence.models.dto.TypeDTO;
import com.moby.dashboard.persistence.models.entity.TypeDocument;
import com.moby.dashboard.persistence.repository.ITypeRepository;
import com.moby.dashboard.service.ITypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private ITypeRepository typeRepository;


    private ModelMapper modelMapper=new ModelMapper();




    @Override
    public void create(TypeDTO typeDTO) {
        typeRepository.save(modelMapper.map(typeDTO, TypeDocument.class));
    }





    @Override
    public List<TypeDTO> findAll() {
        List<TypeDocument> typeDocumentList =typeRepository.findAll();
        if (typeDocumentList.isEmpty()){
            throw new EmptyException("Type list is empty");
        }
        return mapperListClassToListDto(typeDocumentList);
    }

    @Override
    public TypeDTO findById(Long id) {
        return modelMapper.map(findByIdOrThrowException(id),TypeDTO.class);
    }


    @Override
    public void updateById(TypeDTO typeDTO, Long id) {
        TypeDocument typeDocument =findByIdOrThrowException(id);
        typeDocument.setName(typeDTO.getName());
        typeRepository.save(typeDocument);

    }

    @Override
    public void DeleteById(Long id) {
        TypeDocument typeDocument =findByIdOrThrowException(id);
        typeRepository.deleteById(typeDocument.getId());

    }


    public List<TypeDTO> mapperListClassToListDto(List<TypeDocument> typeDocumentList){
        List<TypeDTO> typeDTOS=new ArrayList<>();
        for (TypeDocument typeDocument : typeDocumentList) {

            typeDTOS.add(modelMapper.map(typeDocument,TypeDTO.class));
        }

        return typeDTOS;

    }

    public TypeDocument findByIdOrThrowException(Long id){
        TypeDocument typeDocument =typeRepository.findById(id)
                .orElseThrow(()->new NotFoundTypeIdException("Id not exist"));
        return typeDocument;
    }


}
