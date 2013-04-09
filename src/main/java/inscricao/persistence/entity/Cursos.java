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
@Table(name = "cursos")
@NamedQueries({
  @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")})
public class Cursos implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "curso")
  private String curso;
  @Size(max = 100)
  @Column(name = "descricao")
  private String descricao;
  @OneToMany(mappedBy = "idcursos")
  private Collection<Inscricao> inscricaoCollection;

  public Cursos() {
  }

  public Cursos(Integer id) {
    this.id = id;
  }

  public Cursos(Integer id, String curso) {
    this.id = id;
    this.curso = curso;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
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
    if (!(object instanceof Cursos)) {
      return false;
    }
    Cursos other = (Cursos) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "inscricao.persistence.entity.Cursos[ id=" + id + " ]";
  }
  
}
