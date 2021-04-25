FROM cockroachdb/cockroach
MAINTAINER Ricardo
CMD ["start-single-node", "--insecure", "--store=type=mem,size=800MiB"]
