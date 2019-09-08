FROM python:3.5.2

ENV PYTHONUNBUFFERED 1

RUN mkdir /syndicate

# Set the working directory to /syndicate
WORKDIR /syndicate

# Copy the current directory contents into the container at /SportsRoom
ADD . /syndicate/

# Install any needed packages specified in requirements.txt
RUN pip install -r requirements.txt

EXPOSE 8000

CMD ["/bin/bash", "-c", "python manage.py makemigrations && python manage.py migrate && python manage.py runserver 0.0.0.0:8000"]
