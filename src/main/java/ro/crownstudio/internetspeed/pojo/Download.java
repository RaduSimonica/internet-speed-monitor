package ro.crownstudio.internetspeed.pojo;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "Download")
@Table(name = "download")
public class Download {

	@Id
	@SequenceGenerator(name = "download_sequence", sequenceName = "download_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "download_sequence")
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
	private DownloadLatency latency;
}