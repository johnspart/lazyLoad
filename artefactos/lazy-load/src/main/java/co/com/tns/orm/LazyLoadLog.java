package co.com.tns.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_LAZY_LOAD_LOG")
public class LazyLoadLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -552299585088872503L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NUMERO_DOCUMENTO", length = 25, nullable = false)
	private String numeroDocumento;
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL", insertable = false, updatable = false)
	private Date fecha;
	@Column(name = "INPUT_FILE_CONTENT", length = 1000, nullable = false)
	private String inputFileContent;
	@Column(name = "OUTPUT_FILE_CONTENT", length = 1000, nullable = false)
	private String outputFileContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getInputFileContent() {
		return inputFileContent;
	}

	public void setInputFileContent(String inputFileContent) {
		this.inputFileContent = inputFileContent;
	}

	public String getOutputFileContent() {
		return outputFileContent;
	}

	public void setOutputFileContent(String outputFileContent) {
		this.outputFileContent = outputFileContent;
	}
}
