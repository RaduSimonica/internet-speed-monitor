package ro.crownstudio.internetspeed.pojo;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity(name = "SpeedResult")
@Table(name = "speed_result")
public class SpeedResult {

	@Id
	@SequenceGenerator(name = "speed_result_sequence", sequenceName = "speed_result_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "speed_result_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@SerializedName("result")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private Result result;

	@SerializedName("server")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private Server server;

	@SerializedName("download")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private Download download;

	@SerializedName("packetLoss")
	@Column(name = "packet_loss", updatable = false, nullable = false)
	private Integer packetLoss;

	@SerializedName("upload")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private Upload upload;

	@SerializedName("ping")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private Ping ping;

	@SerializedName("isp")
	@Column(name = "isp", updatable = false, nullable = false)
	private String isp;

	@SerializedName("type")
	@Column(name = "type", updatable = false, nullable = false)
	private String type;

	@SerializedName("interface")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id")
	private NetworkInterface networkInterface;

	@SerializedName("timestamp")
	@Column(name = "timestamp", updatable = false, nullable = false)
	private Date timestamp;
}