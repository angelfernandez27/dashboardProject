package com.moby.dashboard.service.imp;

import com.moby.dashboard.exception.EmptyException;
import com.moby.dashboard.exception.NotExistIdException;
import com.moby.dashboard.persistence.models.dto.TechnologyDTO;
import com.moby.dashboard.persistence.models.entity.Technology;
import com.moby.dashboard.persistence.repository.ITechnologyRepository;
import com.moby.dashboard.service.ITechnologyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyService implements ITechnologyService {

    @Autowired
    private ITechnologyRepository technologyRepository;


    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public void create(TechnologyDTO technologyDTO) {
        technologyRepository.save(modelMapper.map(technologyDTO,Technology.class));

    }

    @Override
    public List<TechnologyDTO> findAll() {
        if(technologyRepository.findAll().isEmpty())
            throw new EmptyException("Type list is empty");
        return mapperListClassToListDto(technologyRepository.findAll());
    }

    @Override
    public TechnologyDTO findById(Long id) {
        return modelMapper.map(findByIdOrThrowException(id),TechnologyDTO.class);
    }

    @Override
    public void updateById(TechnologyDTO technologyDTO, Long id) {
        technologyRepository.save(modelMapper.map(technologyDTO,findByIdOrThrowException(id).getClass()));

    }

    @Override
    public void DeleteById(Long id) {
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
