package ro.crownstudio.internetspeed.pojo;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "Upload")
@Table(name = "upload")
public class Upload {

	@Id
	@SequenceGenerator(name = "upload_sequence", sequenceName = "upload_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "upload_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@SerializedName("elapsed")
	@Column(name = "elapsed", updatable = false, nullable = false)
	private Integer elapsed;

	@SerializedName("bandwidth")
	@Column(name = "bandwidth", updatable = false, nullable = false)
	private Integer bandwidth;

	@SerializedName("bytes")
	@Column(name = "bytes", updatable = false, nullable = false)
	private Integer bytes;

	@SerializedName("latency")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private UploadLatency latency;
}