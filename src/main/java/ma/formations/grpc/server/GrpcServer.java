package ma.formations.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ma.formations.grpc.service.CalculatorService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Créer le serveur gRPC sur le port 9999
        Server grpcServer = ServerBuilder.forPort(9999)
                .addService(new CalculatorService())
                .build();

        // Démarrer le serveur
        grpcServer.start();
        System.out.println("✅ Serveur gRPC démarré : http://localhost:9999");
        System.out.println("📡 En attente de requêtes...");

        // Garder le serveur actif
        grpcServer.awaitTermination();
    }
}