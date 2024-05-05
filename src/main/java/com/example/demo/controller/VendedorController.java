package com.example.demo.controller;
import com.example.demo.model.Vendedor;
import com.example.demo.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/api/Vendedor")
public class VendedorController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @Autowired
    private VendedorService vendedorService;


    @GetMapping("/{id}")
    public Vendedor obterVendedorPorId(@PathVariable Long id) {
        return vendedorService.obterVendedorPorId(id);
    }

    @GetMapping
    public List<Vendedor> obterTodosVendedors (){
        return vendedorService.obterTodosVendedores();
    }

    @PostMapping
    public ResponseEntity<?> addVendedor(@RequestBody Vendedor vendedor){
        try {
            Vendedor novoVendedor = vendedorService.criarVendedor(vendedor);
            return ResponseEntity.ok(novoVendedor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> atualizarVendedor(@PathVariable Long id, @RequestBody Vendedor VendedorAtualizado) {
        Vendedor Vendedor = vendedorService.obterVendedorPorId(id);
        if (Vendedor == null) {
            return ResponseEntity.notFound().build();
        }
        Vendedor VendedorAtualizadoResult = vendedorService.atualizarVendedor(id, VendedorAtualizado);
        return ResponseEntity.ok(VendedorAtualizadoResult);
    }


    @DeleteMapping("/{id}")
    public boolean  deletarVendedor(@PathVariable Long id){
        return vendedorService.deletarVendedorPorId(id);
    }

    @GetMapping("/{id}/mensagem")
    public String SeApresentarPorId(@PathVariable Long id) {
        return vendedorService.SeApresentarPorId(id);
    }

}
