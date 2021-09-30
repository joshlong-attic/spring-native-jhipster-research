package jhipster.liquibase;

import liquibase.configuration.LiquibaseConfiguration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourceHint;
import org.springframework.nativex.hint.TypeHint;

@NativeHint(
	trigger = LiquibaseConfiguration.class,
	resources = {
		@ResourceHint(
			patterns = {
				"liquibase.build.properties",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.2.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.3.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.4.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.5.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.6.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.7.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.9.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.10.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.0.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.1.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.2.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.3.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.4.xsd",
				"www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd",
				"www.liquibase.org/xml/ns/pro/liquibase-pro-3.8.xsd",
				"www.liquibase.org/xml/ns/pro/liquibase-pro-3.9.xsd",
				"www.liquibase.org/xml/ns/pro/liquibase-pro-3.10.xsd",
				"www.liquibase.org/xml/ns/pro/liquibase-pro-4.0.xsd",
				"www.liquibase.org/xml/ns/pro/liquibase-pro-4.1.xsd",
				"www.liquibase.org/xml/ns/pro/liquibase-pro-4.2.xsd",
				"www.liquibase.org/xml/ns/pro/liquibase-pro-4.3.xsd",
				"www.liquibase.org/xml/ns/pro/liquibase-pro-4.4.xsd"
			},
			isBundle = false
		),
		@ResourceHint(patterns = {"com.sun.org.apache.xerces.internal.impl.xpath.regex.message", "liquibase/i18n/liquibase-core"}, isBundle = true)
	},
	types = @TypeHint(
		typeNames = {
			"com.sun.org.apache.xerces.internal.impl.dv.xs.ExtendedSchemaDVFactoryImpl",
			"com.sun.org.apache.xerces.internal.impl.dv.xs.SchemaDVFactoryImpl",
			"com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl",
			"com.sun.xml.internal.stream.events.XMLEventFactoryImpl",
			"liquibase.AbstractExtensibleObject",
			"liquibase.change.AbstractChange",
			"liquibase.change.AbstractSQLChange",
			"liquibase.change.ChangeFactory",
			"liquibase.change.ColumnConfig",
			"liquibase.change.ConstraintsConfig",
			"liquibase.change.core.AbstractModifyDataChange",
			"liquibase.change.core.AddAutoIncrementChange",
			"liquibase.change.core.AddColumnChange",
			"liquibase.change.core.AddDefaultValueChange",
			"liquibase.change.core.AddForeignKeyConstraintChange",
			"liquibase.change.core.AddLookupTableChange",
			"liquibase.change.core.AddNotNullConstraintChange",
			"liquibase.change.core.AddPrimaryKeyChange",
			"liquibase.change.core.AddUniqueConstraintChange",
			"liquibase.change.core.AlterSequenceChange",
			"liquibase.change.core.CreateIndexChange",
			"liquibase.change.core.CreateProcedureChange",
			"liquibase.change.core.CreateSequenceChange",
			"liquibase.change.core.CreateTableChange",
			"liquibase.change.core.CreateViewChange",
			"liquibase.change.core.DeleteDataChange",
			"liquibase.change.core.DropAllForeignKeyConstraintsChange",
			"liquibase.change.core.DropColumnChange",
			"liquibase.change.core.DropDefaultValueChange",
			"liquibase.change.core.DropForeignKeyConstraintChange",
			"liquibase.change.core.DropIndexChange",
			"liquibase.change.core.DropNotNullConstraintChange",
			"liquibase.change.core.DropPrimaryKeyChange",
			"liquibase.change.core.DropProcedureChange",
			"liquibase.change.core.DropSequenceChange",
			"liquibase.change.core.DropTableChange",
			"liquibase.change.core.DropUniqueConstraintChange",
			"liquibase.change.core.DropViewChange",
			"liquibase.change.core.EmptyChange",
			"liquibase.change.core.ExecuteShellCommandChange",
			"liquibase.change.core.InsertDataChange",
			"liquibase.change.core.LoadDataChange",
			"liquibase.change.core.LoadUpdateDataChange",
			"liquibase.change.core.MergeColumnChange",
			"liquibase.change.core.ModifyDataTypeChange",
			"liquibase.change.core.OutputChange",
			"liquibase.change.core.RawSQLChange",
			"liquibase.change.core.RenameColumnChange",
			"liquibase.change.core.RenameSequenceChange",
			"liquibase.change.core.RenameTableChange",
			"liquibase.change.core.RenameViewChange",
			"liquibase.change.core.SQLFileChange",
			"liquibase.change.core.SetColumnRemarksChange",
			"liquibase.change.core.SetTableRemarksChange",
			"liquibase.change.core.StopChange",
			"liquibase.change.core.TagDatabaseChange",
			"liquibase.change.core.UpdateDataChange",
			"liquibase.change.custom.CustomChangeWrapper",
			"liquibase.changelog.StandardChangeLogHistoryService",
			"liquibase.configuration.GlobalConfiguration",
			"liquibase.configuration.HubConfiguration",
			"liquibase.database.core.H2Database",
			"liquibase.database.core.MariaDBDatabase",
			"liquibase.database.core.MSSQLDatabase",
			"liquibase.database.core.MySQLDatabase",
			"liquibase.database.core.OracleDatabase",
			"liquibase.database.core.PostgresDatabase",
			"liquibase.database.jvm.JdbcConnection",
			"liquibase.datatype.core.BigIntType",
			"liquibase.datatype.core.BlobType",
			"liquibase.datatype.core.BooleanType",
			"liquibase.datatype.core.CharType",
			"liquibase.datatype.core.ClobType",
			"liquibase.datatype.core.CurrencyType",
			"liquibase.datatype.core.DatabaseFunctionType",
			"liquibase.datatype.core.DateTimeType",
			"liquibase.datatype.core.DateType",
			"liquibase.datatype.core.DecimalType",
			"liquibase.datatype.core.DoubleType",
			"liquibase.datatype.core.FloatType",
			"liquibase.datatype.core.IntType",
			"liquibase.datatype.core.MediumIntType",
			"liquibase.datatype.core.NCharType",
			"liquibase.datatype.core.NumberType",
			"liquibase.datatype.core.NVarcharType",
			"liquibase.datatype.core.SmallIntType",
			"liquibase.datatype.core.TimestampType",
			"liquibase.datatype.core.TimeType",
			"liquibase.datatype.core.TinyIntType",
			"liquibase.datatype.core.UnknownType",
			"liquibase.datatype.core.UUIDType",
			"liquibase.datatype.core.VarcharType",
			"liquibase.datatype.core.XMLType",
			"liquibase.executor.ExecutorService",
			"liquibase.executor.jvm.JdbcExecutor",
			"liquibase.hub.HubServiceFactory",
			"liquibase.license.LicenseServiceFactory",
			"liquibase.lockservice.StandardLockService",
			"liquibase.logging.core.LogServiceFactory",
			"liquibase.parser.ChangeLogParserCofiguration",
			"liquibase.plugin.AbstractPlugin",
			"liquibase.serializer.AbstractLiquibaseSerializable",
			"liquibase.sql.visitor.AppendSqlVisitor",
			"liquibase.sql.visitor.PrependSqlVisitor",
			"liquibase.sql.visitor.RegExpReplaceSqlVisitor",
			"liquibase.sql.visitor.ReplaceSqlVisitor",
			"liquibase.changelog.RanChangeSet",
			"com.zaxxer.hikari.HikariConfig",
			"java.util.concurrent.CopyOnWriteArrayList",
			"java.sql.Statement[]",
			"com.zaxxer.hikari.HikariDataSource",
			"liquibase.configuration.LiquibaseConfiguration",
			"com.zaxxer.hikari.util.ConcurrentBag.IConcurrentBagEntry[]",
			"liquibase.change.core.LoadDataColumnConfig"},
		access = AccessBits.ALL
	),
	options = "--enable-url-protocols=http"
)
@RequiredArgsConstructor
@SpringBootApplication
public class LiquibaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquibaseApplication.class, args);
	}

	@Bean
	ApplicationRunner blogRunner(JdbcTemplate template) {
		return args -> template
			.query("select * from blog", (rs, rowNum) -> new Blog(rs.getInt("id"), rs.getString("handle"), rs.getString("name")))
			.forEach(System.out::println);
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Blog {
	private Integer id;
	private String handle, name;
}



