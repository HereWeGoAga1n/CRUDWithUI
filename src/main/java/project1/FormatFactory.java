package project1;

import DBConverter.impl.nosql.Cassandra;
import DBConverter.impl.nosql.MongoDB;
import DBConverter.impl.nosql.Neo4J;
import DBConverter.impl.nosql.Redis;
import DBConverter.impl.sql.H2;
import DBConverter.impl.sql.MySQL;
import DBConverter.impl.sql.PostgreSQL;
import DataFormatConverter.impl.CSVConverter;
import DataFormatConverter.impl.XMLConverter;
import DataFormatConverter.impl.YamlConverter;
import project1.cmd.DBCmdProcessor;
import util.Constants.Format;
import DataFormatConverter.impl.JasonConverter;
import project1.cmd.BinaryFormatCmdProcessor;
import project1.cmd.Executable;
import project1.cmd.StringFormatCmdProcessor;

public class FormatFactory {

    private final Executable jsonExecutable = new StringFormatCmdProcessor(new JasonConverter());
    private final Executable xmlExecutable = new StringFormatCmdProcessor(new XMLConverter());
    private final Executable csvExecutable = new StringFormatCmdProcessor(new CSVConverter());
    private final Executable yamlExecutable = new StringFormatCmdProcessor(new YamlConverter());
    private final Executable binaryExecutable = new BinaryFormatCmdProcessor();
    private final Executable h2Executable = new DBCmdProcessor(new H2());
    private final Executable mySQLExecutable = new DBCmdProcessor(new MySQL());
    private final Executable postgreSQLExecutable = new DBCmdProcessor(new PostgreSQL());
    private final Executable cassandraExecutable = new DBCmdProcessor(new Cassandra());
    private final Executable mongoDBExecutable = new DBCmdProcessor(new MongoDB());
    private final Executable neo4JExecutable = new DBCmdProcessor(new Neo4J());
    private final Executable redisExecutable = new DBCmdProcessor(new Redis());
    public static Executable instance;

    public Executable getInstance(String format) {
        switch (format.toLowerCase()) {
            case Format.YAML:
                instance = yamlExecutable;
                break;
            case Format.CSV:
                instance = csvExecutable;
                break;
            case Format.XML:
                instance = xmlExecutable;
                break;
            case Format.JSON:
                instance = jsonExecutable;
                break;
            case Format.BINARY:
                instance = binaryExecutable;
                break;
            case Format.H2:
                instance = h2Executable;
                break;
            case Format.MY_SQL:
                instance = mySQLExecutable;
                break;
            case Format.POSTGRE_SQL:
                instance = postgreSQLExecutable;
                break;
            case Format.CASSANDRA:
                instance = cassandraExecutable;
                break;
            case Format.MONGO_DB:
                instance = mongoDBExecutable;
                break;
            case Format.NEO_4J:
                instance = neo4JExecutable;
                break;
            case Format.REDIS:
                instance = redisExecutable;
                break;
            default:
                throw new IllegalArgumentException("Данная программа не работает с форматом\n" + format);
        }
        return instance;
    }
}