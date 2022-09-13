package com.moby.dashboard.service.imp;

import com.moby.dashboard.exception.EmptyException;
import com.moby.dashboard.exception.NotExistIdException;
import com.moby.dashboard.persistence.models.dto.CandidateTechnologyDTO;
import com.moby.dashboard.persistence.models.entity.Candidate;
import com.moby.dashboard.persistence.models.entity.CandidateTechnology;
import com.moby.dashboard.persistence.repository.ICandidateTechnologyRepository;
import com.moby.dashboard.service.ICandidateTechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class CandidateTechnologyService implements ICandidateTechnologyService {

    @Autowired
    private ICandidateTechnologyRepository candidateTechnologyRepository;


    private ModelMapper modelMapper=new ModelMapper();
    @Override
    public void create(CandidateTechnologyDTO candidateTechnologyDTO) {
        log.info("dto of create of Candidate \n "+"\n"+candidateTechnologyDTO);
       CandidateTechnology candidateTechnology= candidateTechnologyRepository.save(modelMapper.map(candidateTechnologyDTO, CandidateTechnology.class));
        log.debug("response save in create \n"+candidateTechnology);


    }

    @Override
    public List<CandidateTechnologyDTO> findAll() {
        List<CandidateTechnology>candidateTechnologyList=candidateTechnologyRepository.findAll();
        if (candidateTechnologyList.isEmpty())
            throw new EmptyException("candidateTechnology List is empty.");
        log.debug("Response of findAll in CandidateTechnology \n"+candidateTechnologyList);
        return mapperListClassToListDto(candidateTechnologyList);
    }

    @Override
    public CandidateTechnologyDTO findById(Long id) {
        CandidateTechnology candidateTechnology=findByIdOrThrowException(id);
        log.debug("Response of findById in CandidateTechnology \n"+candidateTechnology);
        return modelMapper.map(candidateTechnology,CandidateTechnologyDTO.class);
    }

    @Override
    public void updateById(CandidateTechnologyDTO candidateTechnologyDTO, Long id) {
        log.info("Id and dto in updateById of CandidateTechnology \n"+id+"\n"+candidateTechnologyDTO);
        CandidateTechnology candidateTechnology=candidateTechnologyRepository.save(modelMapper.map(candidateTechnologyDTO,findByIdOrThrowException(id).getClass()));
        log.debug("Response of updateById in CandidateTechnology \n"+candidateTechnology);
    }

    @Override
    public void deleteById(Long id) {
        log.info("id in deleteById of CandidateTechnology "+id);
        candidateTechnologyRepository.deleteById(findByIdOrThrowException(id).getId());

    }

    public List<CandidateTechnologyDTO> mapperListClassToListDto(List<CandidateTechnology> candidateTechnologies){
        List<CandidateTechnologyDTO> candidateTechnologyList=new ArrayList<>();
        for (CandidateTechnology candidateTechnology : candidateTechnologies) {

            candidateTechnologyList.add(modelMapper.map(candidateTechnology,CandidateTechnologyDTO.class));
        }

        return candidateTechnologyList;

    }

    public CandidateTechnology findByIdOrThrowException(Long id){
        CandidateTechnology candidateTechnology=candidateTechnologyRepository.findById(id)
                .orElseThrow(()->new NotExistIdException("Id not exist."));
        return candidateTechnology;
    }
}
