FROM cockroachdb/cockroach
MAINTAINER Ricardo
CMD ["start", 
    "--insecure", 
    "--store=type=mem,size=800MiB", 
    "--listen-addr=localhost:26257",
    "--http-addr=localhost:8080",
    "--join=localhost:26257,localhost:26258,localhost:26259",
    "--background"]
CMD ["start", 
    "--insecure", 
    "--store=type=mem,size=800MiB", 
    "--listen-addr=localhost:26258",
    "--http-addr=localhost:8081",
    "--join=localhost:26257,localhost:26258,localhost:26259",
    "--background"]
CMD ["start", 
    "--insecure", 
    "--store=type=mem,size=800MiB", 
    "--listen-addr=localhost:26259",
    "--http-addr=localhost:8082",
    "--join=localhost:26257,localhost:26258,localhost:26259",
    "--background"]
