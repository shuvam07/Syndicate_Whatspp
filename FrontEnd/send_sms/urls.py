from django.conf.urls import  url

from . import views

urlpatterns = (
    url(r'^send_sms/$', views.send_sms),
)