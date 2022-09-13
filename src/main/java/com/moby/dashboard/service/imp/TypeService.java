package com.moby.dashboard.service.imp;

import com.moby.dashboard.exception.EmptyException;
import com.moby.dashboard.exception.NotExistIdException;
import com.moby.dashboard.persistence.models.dto.TypeDocumentDTO;
import com.moby.dashboard.persistence.models.entity.TypeDocument;
import com.moby.dashboard.persistence.repository.ITypeRepository;
import com.moby.dashboard.service.ITypeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class TypeService implements ITypeService {

    @Autowired
    private ITypeRepository typeRepository;


    private ModelMapper modelMapper=new ModelMapper();




    @Override
    public void create(TypeDocumentDTO typeDocumentDTO) {
        log.info("Dto of create method in TypeDocument \n"+typeDocumentDTO);
        TypeDocument typeDocument=typeRepository.save(modelMapper.map(typeDocumentDTO, TypeDocument.class));
        log.debug("Response save method in Typedocument \n"+typeDocument);
    }





    @Override
    public List<TypeDocumentDTO> findAll() {
        List<TypeDocument>typeDocumentList=typeRepository.findAll();
        if (typeDocumentList.isEmpty())
            throw new EmptyException("Type list is empty");
        log.debug("Response in findAll method of TypeDocument \n"+typeDocumentList);
        return mapperListClassToListDto(typeDocumentList);
    }

    @Override
    public TypeDocumentDTO findById(Long id) {
        TypeDocument typeDocument=findByIdOrThrowException(id);
        log.debug("Response of findById method in TypeDocument \n"+typeDocument);
        return modelMapper.map(typeDocument, TypeDocumentDTO.class);
    }


    @Override
    public void updateById(TypeDocumentDTO typeDocumentDTO, Long id) {
        log.info("Id and dto params of updateById method of TypeDocument \n"+id+"\n"+typeDocumentDTO);
        TypeDocument typeDocument=typeRepository.save(modelMapper.map(typeDocumentDTO,findByIdOrThrowException(id).getClass()));
        log.debug("Response save method in updateById of TypeDocument \n"+typeDocument);

    }

    @Override
    public void deleteById(Long id) {
        log.info("Id params of deleteById method in TypeDocument");
        typeRepository.deleteById(findByIdOrThrowException(id).getId());

    }


    public List<TypeDocumentDTO> mapperListClassToListDto(List<TypeDocument> typeDocumentList){
        List<TypeDocumentDTO> typeDocumentDTOS =new ArrayList<>();
        for (TypeDocument typeDocument : typeDocumentList) {

            typeDocumentDTOS.add(modelMapper.map(typeDocument, TypeDocumentDTO.class));
        }

        return typeDocumentDTOS;

    }

    public TypeDocument findByIdOrThrowException(Long id){
        TypeDocument typeDocument =typeRepository.findById(id)
                .orElseThrow(()->new NotExistIdException("Id not exist"));
        return typeDocument;
    }


}
