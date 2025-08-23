# PrimeRangesAPI

## Description

A simple spring boot application providing a single REST
endpoint which returns a list of prime numbers up to the input.

## Endpoints

| Endpoint    | Request Type | Parameters                         | Example Return Value                                                   |
|-------------|--------------|------------------------------------|------------------------------------------------------------------------|
| /primes/[n] | GET          | n - Any non-negative integer value | <pre>{<br>&nbsp;"Initial": 10,<br>&nbsp;"Primes": [2,3,5,7]<br>}</pre> |

## Configuration

| Option                                  | Location          | Description                                                                      | Example Value |
|-----------------------------------------|-------------------|----------------------------------------------------------------------------------|---------------|
| `primerangesapi.primeCalculationMethod` | `application.yml` | Sets the prime calculation method, accepted values are `BRUTE_FORCE` and `GUAVA` | `GUAVA`       |
