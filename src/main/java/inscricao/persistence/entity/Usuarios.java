/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
  @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")})
public class Usuarios implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "nome")
  private String nome;
  @Size(max = 14)
  @Column(name = "cpf")
  private String cpf;
  @Size(max = 12)
  @Column(name = "rg")
  private String rg;
  @Size(max = 100)
  @Column(name = "endereco")
  private String endereco;
  @Column(name = "numero")
  private Integer numero;
  @Size(max = 20)
  @Column(name = "complemento")
  private String complemento;
  @Size(max = 10)
  @Column(name = "cep")
  private String cep;
  @Size(max = 50)
  @Column(name = "bairro")
  private String bairro;
  @Size(max = 50)
  @Column(name = "cidade")
  private String cidade;
  @Size(max = 25)
  @Column(name = "estado")
  private String estado;
  @Size(max = 20)
  @Column(name = "telefone")
  private String telefone;
  @Size(max = 20)
  @Column(name = "celular")
  private String celular;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
  @Size(max = 100)
  @Column(name = "email")
  private String email;
  @OneToMany(mappedBy = "idusuarios")
  private Collection<Inscricao> inscricaoCollection;

  public Usuarios() {
  }

  public Usuarios(Integer id) {
    this.id = id;
  }

  public Usuarios(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Collection<Inscricao> getInscricaoCollection() {
    return inscricaoCollection;
  }

  public void setInscricaoCollection(Collection<Inscricao> inscricaoCollection) {
    this.inscricaoCollection = inscricaoCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Usuarios)) {
      return false;
    }
    Usuarios other = (Usuarios) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "inscricao.persistence.entity.Usuarios[ id=" + id + " ]";
  }
  
}
