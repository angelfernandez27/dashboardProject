package com.moby.dashboard.service.imp;

import com.moby.dashboard.exception.EmptyException;
import com.moby.dashboard.exception.NotExistIdException;
import com.moby.dashboard.persistence.models.dto.TechnologyDTO;
import com.moby.dashboard.persistence.models.entity.Technology;
import com.moby.dashboard.persistence.repository.ITechnologyRepository;
import com.moby.dashboard.service.ITechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class TechnologyService implements ITechnologyService {

    @Autowired
    private ITechnologyRepository technologyRepository;


    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public void create(TechnologyDTO technologyDTO) {
        log.info("dto in create Technology \n"+technologyDTO);
        Technology technology=technologyRepository.save(modelMapper.map(technologyDTO,Technology.class));
        log.debug("Response save method of Technology \n"+technology);

    }

    @Override
    public List<TechnologyDTO> findAll() {
        List<Technology>technologyList=technologyRepository.findAll();
        if(technologyList.isEmpty())
            throw new EmptyException("Type list is empty");
        log.debug("Response of findAll in Technology \n"+technologyList);
        return mapperListClassToListDto(technologyList);
    }

    @Override
    public TechnologyDTO findById(Long id) {
        Technology technology=findByIdOrThrowException(id);
        log.debug("Response of findById id Technology \n"+technology);
        return modelMapper.map(technology,TechnologyDTO.class);
    }

    @Override
    public void updateById(TechnologyDTO technologyDTO, Long id) {
        log.info("id and dto of updateById in Technology \n"+id+"\n"+technologyDTO);
        Technology technology=technologyRepository.save(modelMapper.map(technologyDTO,findByIdOrThrowException(id).getClass()));
        log.debug("Response save method in updateById of Technology \n"+technology);

    }

    @Override
    public void deleteById(Long id) {
        log.info("id param in deleteById"+id);
        technologyRepository.deleteById(findByIdOrThrowException(id).getId());

    }

    public List<TechnologyDTO> mapperListClassToListDto(List<Technology> technologyList){
        List<TechnologyDTO> technologyDTOS=new ArrayList<>();
        for (Technology technology : technologyList) {

            technologyDTOS.add(modelMapper.map(technology,TechnologyDTO.class));
        }

        return technologyDTOS;

    }

    public Technology findByIdOrThrowException(Long id){
        Technology technology =technologyRepository.findById(id)
                .orElseThrow(()->new NotExistIdException("Id not exist"));
        return technology;
    }
}
