package com.example.demo.controller;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/api/Cliente")
public class ClienteController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/{id}")
    public Cliente obterClientePorId(@PathVariable Long id) {
        return clienteService.obterClientePorId(id);
    }

    @GetMapping
    public List<Cliente> obterTodosClientes (){
        return clienteService.obterTodosClientes();
    }

    @PostMapping
    public ResponseEntity<?> addCliente(@RequestBody Cliente cliente){
        try {
            Cliente novoCliente = clienteService.criarCliente(cliente);
            return ResponseEntity.ok(novoCliente); // Retorna o cliente criado com sucesso
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Retorna a mensagem de erro ao usuário
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteService.obterClientePorId(id); // Obtém o cliente existente pelo ID
        if (cliente == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o cliente não for encontrado
        }
        Cliente clienteAtualizadoResult = clienteService.atualizarCliente(id, clienteAtualizado); // Atualiza o cliente
        return ResponseEntity.ok(clienteAtualizadoResult); // Retorna o cliente atualizado
    }


    @DeleteMapping("/{id}")
    public boolean  deletarCliente(@PathVariable Long id){
        return clienteService.deletarClientePorId(id);
    }

    @GetMapping("/{id}/mensagem")
    public String SeApresentarPorId(@PathVariable Long id) {
        return clienteService.SeApresentarPorId(id);
    }

}
