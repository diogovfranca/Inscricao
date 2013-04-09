/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "inscricao")
@NamedQueries({
  @NamedQuery(name = "Inscricao.findAll", query = "SELECT i FROM Inscricao i")})
public class Inscricao implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @JoinColumn(name = "idusuarios", referencedColumnName = "id")
  @ManyToOne
  private Usuarios idusuarios;
  @JoinColumn(name = "idcursos", referencedColumnName = "id")
  @ManyToOne
  private Cursos idcursos;

  public Inscricao() {
  }

  public Inscricao(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Usuarios getIdusuarios() {
    return idusuarios;
  }

  public void setIdusuarios(Usuarios idusuarios) {
    this.idusuarios = idusuarios;
  }

  public Cursos getIdcursos() {
    return idcursos;
  }

  public void setIdcursos(Cursos idcursos) {
    this.idcursos = idcursos;
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
    if (!(object instanceof Inscricao)) {
      return false;
    }
    Inscricao other = (Inscricao) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "inscricao.persistence.entity.Inscricao[ id=" + id + " ]";
  }
  
}
