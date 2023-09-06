package com.importer.importxmlbackend.service;

import com.importer.importxmlbackend.exception.FileNotFoundException;
import com.importer.importxmlbackend.model.Agent;
import com.importer.importxmlbackend.model.dto.AgentDTO;
import com.importer.importxmlbackend.repository.AgentRepository;
import com.importer.importxmlbackend.repository.GeneratedRepository;
import com.importer.importxmlbackend.repository.MediumPriceRepository;
import com.importer.importxmlbackend.repository.PurchaseRepository;
import com.importer.importxmlbackend.repository.RegionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ImportXmlService {

    public static final String CHAR_SET = "UTF-8";

    private final AgentRepository agentRepository;

    private final GeneratedRepository generatedRepository;

    private final MediumPriceRepository mediumPriceRepository;

    private final PurchaseRepository purchaseRepository;

    private final RegionRepository regionRepository;

    public void createFile(MultipartFile multipartFile) {
        final File file = new File(multipartFile.getName());
        final Agent agent = Agent.toPersist(convertFromXml(file));
        agentRepository.save(agent);
        if (!regionRepository.saveAll(agent.getRegions()).isEmpty()) {
            agent.getRegions().forEach(r -> {
                generatedRepository.saveAll(r.getGenerated());
                mediumPriceRepository.saveAll(r.getMediumPrice());
                purchaseRepository.saveAll(r.getPurchase());
            });
        }
    }

    public List<Agent> getAllFiles() {
        final List<Agent> savedAgent = agentRepository.findAll();
        if (!savedAgent.isEmpty()) {
            return savedAgent;
        } else {
            throw new FileNotFoundException("Agentes não encontrado");
        }
    }

    public void deleteById(Long agentId) {
        final Optional<Agent> savedAgent = agentRepository.findById(agentId);
        if (savedAgent.isPresent()) {
            agentRepository.delete(savedAgent.get());
        } else {
            throw new FileNotFoundException("Arquivo nao encontrado, tente novamente.");
        }
    }

    private AgentDTO convertFromXml(File file) {
        AgentDTO agent;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AgentDTO.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            agent = (AgentDTO) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new FileNotFoundException("File not found");
        }
        return agent;
    }

}

