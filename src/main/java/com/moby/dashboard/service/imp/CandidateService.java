package com.moby.dashboard.service.imp;

import com.moby.dashboard.exception.EmptyException;
import com.moby.dashboard.exception.NotExistIdException;
import com.moby.dashboard.persistence.models.dto.CandidateDTO;
import com.moby.dashboard.persistence.models.entity.Candidate;
import com.moby.dashboard.persistence.repository.ICandidateRepository;
import com.moby.dashboard.service.ICandidateService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class CandidateService implements ICandidateService {

    @Autowired
    private ICandidateRepository candidateRepository;

    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public void create(CandidateDTO candidateDTO) {
        log.info("dto in create candidate \n"+candidateDTO);
        Candidate candidate=candidateRepository.save(modelMapper.map(candidateDTO,Candidate.class));
        log.debug("Candidate created \n"+candidate);
    }

    @Override
    public List<CandidateDTO> findAll() {
        List<Candidate> candidateList=candidateRepository.findAll();
        List<CandidateDTO>candidateDTOList=new ArrayList<>();
        if(candidateList.isEmpty())
            throw new EmptyException("List id Empty.");
        candidateDTOList=mapperListClassToListDto(candidateList);
        log.debug("response of findAll in candidate \n"+candidateList);
        return candidateDTOList;
    }

    @Override
    public CandidateDTO findById(Long id) {
        log.info("findById of Candidate "+id);
        Candidate candidate=findByIdOrThrowException(id);
        log.debug("response findById in Candidate "+candidate);
        return modelMapper.map(candidate,CandidateDTO.class);
    }

    @Override
    public void updateById(CandidateDTO candidateDTO, Long id) {
        log.info("id and dto of updateById of Candidate \n "+id+"\n"+candidateDTO);
        Candidate candidate=candidateRepository.save(modelMapper.map(candidateDTO,findByIdOrThrowException(id).getClass()));
        log.debug("response save in updateById \n"+candidate);

    }

    @Override
    public void deleteById(Long id) {
        log.info("id in deleteById "+id);
        candidateRepository.deleteById(findByIdOrThrowException(id).getId());
    }

    public List<CandidateDTO> mapperListClassToListDto(List<Candidate> candidateList){
        List<CandidateDTO> candidateDTOS=new ArrayList<>();
        for (Candidate candidate : candidateList) {

            candidateDTOS.add(modelMapper.map(candidate,CandidateDTO.class));
        }

        return candidateDTOS;

    }

    public Candidate findByIdOrThrowException(Long id){
        Candidate candidate=candidateRepository.findById(id)
                .orElseThrow(()->new NotExistIdException("Id not exist."));
        return candidate;
    }
}
