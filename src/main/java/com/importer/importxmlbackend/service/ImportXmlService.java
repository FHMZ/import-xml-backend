package com.importer.importxmlbackend.service;

import com.importer.importxmlbackend.exception.FileNotFoundException;
import com.importer.importxmlbackend.model.Agent;
import com.importer.importxmlbackend.model.dto.AgentDTO;
import com.importer.importxmlbackend.repository.AgentRepository;
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

    public void createFile(MultipartFile multipartFile) {
        final File file = new File(multipartFile.getName());
        final AgentDTO agent = convertFromXml(file);
        log.info("Agent: ", agent);
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

