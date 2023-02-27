package ro.crownstudio.internetspeed.pojo;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "Ping")
@Table(name = "ping")
public class Ping {

	@Id
	@SequenceGenerator(name = "ping_sequence", sequenceName = "ping_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ping_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@SerializedName("high")
	@Column(name = "high", updatable = false, nullable = false)
	private Double high;

	@SerializedName("jitter")
	@Column(name = "jitter", updatable = false, nullable = false)
	private Double jitter;

	@SerializedName("low")
	@Column(name = "low", updatable = false, nullable = false)
	private Double low;

	@SerializedName("latency")
	@Column(name = "latency", updatable = false, nullable = false)
	private Double latency;
}