package com.junior.locadora.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.dto.CadastroDTO;
import com.junior.locadora.services.CadastroService;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroResource {

    @Autowired
    private CadastroService service;

    @GetMapping
    public ResponseEntity<List<CadastroDTO>> findAll() {
        List<Cadastro> list = service.findAll();
        List<CadastroDTO> listDto = list.stream()
                .map(x -> new CadastroDTO(x.getId(), x.getNome(), x.getDescricao(), x.getDuracao(), x.getIdademin(),
                        x.getDataHoraCadastro()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<CadastroDTO> findById(@PathVariable String id) {
        Cadastro obj = service.findById(id);
        CadastroDTO dto = new CadastroDTO(obj.getId(), obj.getNome(), obj.getDescricao(), obj.getDuracao(),
                obj.getIdademin(), obj.getDataHoraCadastro());
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CadastroDTO objDto) {
        Cadastro obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody CadastroDTO objDto, @PathVariable String id) {
        Cadastro obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
